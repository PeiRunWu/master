package com.msb.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class GamePanel extends JPanel implements KeyListener {
    //定义子弹的数组
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    //定义大型敌机的数组
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    //定义小敌敌机的数组
    ArrayList<SmallEnemy> smallEnemies = new ArrayList<SmallEnemy>();
    //定义爆炸的数组
    ArrayList<Bom> boms = new ArrayList<Bom>();
    ArrayList<EnemyBom> enemyBoms = new ArrayList<EnemyBom>();
    //定义游戏是否开始
    boolean isStart = false;
    //定义游戏界面是否显示
    boolean isShow = true;
    //定义飞机的坐标
    int planeX = 200;
    int planeY = 690;
    //判断游戏是否结束
    boolean isDie = false;
    //定义分数
    private int num = 0;

    public GamePanel() {
        this.setFocusable(true);
        addKeyListener(this);
        for (int i = 0; i < 5; i++) {
            smallEnemies.add(new SmallEnemy());
        }
        for (int i = 0; i < 2; i++) {
            enemies.add(new Enemy());
        }
    }

    //初始化
    public void init() {
        //循环20次加入子弹
        int flag = 0;
        while (true) {
            flag++;
            if (flag % 20 == 0) {
                Bullet bullet = new Bullet(planeX + Images.PlaneImages.getIconWidth() / 2, planeY);
                bullets.add(bullet);
            }
            move();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    private void move() {
        if (isStart && isDie == false) {
            //小飞机移动
            for (int i = 0; i < smallEnemies.size(); i++) {
                SmallEnemy smallEnemy = smallEnemies.get(i);
                smallEnemy.move();
                //判断敌机的y值是否大于整个窗口的高度
                if (smallEnemy.getSmallEnemyY() > StartGame.height) {
                    //删除敌机
                    smallEnemies.remove(smallEnemy);
                    //再添加一个新的敌机
                    smallEnemies.add(new SmallEnemy());

                }
            }
            //大型机移动
            if (num % 3 == 0 && num != 0) {
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemie = enemies.get(i);
                    enemie.move();
                    //判断敌机的y值是否大于整个窗口的高度
                    if (enemie.getEnemyY() > StartGame.height) {
                        //删除敌机
                        enemies.remove(enemie);
                        //再添加一个新的敌机
                        enemies.add(new Enemy());
                    }
                }
            }


            //让子弹移动
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                bullet.move();
            }
            //删除越界的子弹
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                if (bullet.getBulletY() < 0) {
                    bullets.remove(bullet);
                }
            }
            //子弹碰到敌机
            for (int i = 0; i < smallEnemies.size(); i++) {
                SmallEnemy smallEnemy = smallEnemies.get(i);
                for (int j = 0; j < bullets.size(); j++) {
                    Bullet bullet = bullets.get(j);
                    if (isHit(bullet, smallEnemy)) {
                        //删除敌机
                        smallEnemies.remove(smallEnemy);
                        smallEnemies.add(new SmallEnemy());
                        //删除子弹
                        bullets.remove(bullet);
                        Bom bom = new Bom(smallEnemy.getSmallEnemyX(), smallEnemy.getSmallEnemyY());
                        boms.add(bom);
                        //分数增加
                        num += 10;
                    }
                }
            }
            //大型敌机碰到子弹
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                for (int j = 0; j < bullets.size(); j++) {
                    Bullet bullet = bullets.get(j);
                    if (isHit(bullet, enemy)) {
                        enemies.remove(enemy);
                        enemies.add(new Enemy());
                        bullets.remove(bullet);
                        EnemyBom enemyBom = new EnemyBom(enemy.getEnemyX(), enemy.getEnemyY());
                        enemyBoms.add(enemyBom);
                        num += 10;
                    }
                }
            }
            //飞机碰到敌机
            for (int i = 0; i < smallEnemies.size(); i++) {
                SmallEnemy smallEnemy = smallEnemies.get(i);
                if (isHit(smallEnemy)) {
                    isDie = true;
                }
            }
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                if (isHit(enemy)) {
                    isDie = true;
                }
            }
            //删除爆炸的图片
            for (int i = 0; i < boms.size(); i++) {
                Bom bom = boms.get(i);
                bom.move();
                if (bom.getCount() > 5) {
                    boms.remove(bom);
                }
            }
            for (int i = 0; i < enemyBoms.size(); i++) {
                EnemyBom enemyBom = enemyBoms.get(i);
                enemyBom.move();
                if (enemyBom.getCount() > 5) {
                    enemyBoms.remove(enemyBom);
                }
            }
        }
    }

    //碰撞检测，判断敌机是否有碰到子弹
    private boolean isHit(Bullet bullet, SmallEnemy smallEnemy) {
        Rectangle enemy = new Rectangle(smallEnemy.getSmallEnemyX(), smallEnemy.getSmallEnemyY(), smallEnemy.getWidth(), smallEnemy.getHeight());
        Point bullets = new Point(bullet.getBulletX(), bullet.getBulletY());
        return enemy.contains(bullets);
    }

    //碰撞检测，判断敌机是否有碰到子弹
    private boolean isHit(Bullet bullet, Enemy enemy) {
        Rectangle enemies = new Rectangle(enemy.getEnemyX(), enemy.getEnemyY(), enemy.getWidth(), enemy.getHeight());
        Point bullets = new Point(bullet.getBulletX(), bullet.getBulletY());
        return enemies.contains(bullets);
    }


    //检测飞机是否有碰到飞机
    private boolean isHit(SmallEnemy smallEnemy) {
        return new Rectangle(planeX + 37, planeY + 40, Images.PlaneImages.getIconWidth(), Images.PlaneImages.getIconHeight()).intersects(new Rectangle(smallEnemy.getSmallEnemyX(), smallEnemy.getSmallEnemyY(), smallEnemy.getWidth(), smallEnemy.getHeight()));
    }

    private boolean isHit(Enemy enemy) {
        return new Rectangle(planeX + 37, planeY + 40, Images.PlaneImages.getIconWidth(), Images.PlaneImages.getIconHeight()).intersects(new Rectangle(enemy.getEnemyX(), enemy.getEnemyY(), enemy.getWidth(), enemy.getHeight()));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制背景图片
        Images.backgroundImages.paintIcon(this, g, 0, 0);
        //子弹显示
        if (isStart && isDie == false) {
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                bullet.drawImage(g);
            }
            //敌机显示
            for (int i = 0; i < smallEnemies.size(); i++) {
                SmallEnemy smallEnemy = smallEnemies.get(i);
                smallEnemy.drawImage(g);
            }
            if (num % 3 == 0 && num != 0) {
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    enemy.drawImage(g);
                }
            }
            //爆炸显示
            for (int i = 0; i < boms.size(); i++) {
                Bom bom = boms.get(i);
                bom.drawImage(g);
            }

            for (int i = 0; i < enemyBoms.size(); i++) {
                EnemyBom enemyBom = enemyBoms.get(i);
                enemyBom.drawImage(g);
            }
            //绘制飞机
            Images.PlaneImages.paintIcon(this, g, planeX, planeY);
            //绘制分数
            g.setColor(new Color(220, 148, 148));
            g.setFont(new Font("微软雅黑", Font.BOLD, 20));
            g.drawString("分数：" + num, 20, 30);
        }
        //绘制开始界面标题
        if (isShow) {
            Images.Aircraft_warImages.paintIcon(this, g, 40, 60);
        }
        //绘制pause界面
        if (isStart == false && isShow == false) {
            Images.PauseImages.paintIcon(this, g, 40, 60);
        }
        if (isDie) {
            Images.Game_overImages.paintIcon(this, g, 40, 60);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_SPACE) {
            if (isDie) {
               System.exit(0);
            } else {
                isStart = !isStart;
                isShow = false;
            }
        }
        if (isStart && isDie == false) {
            if (keycode == KeyEvent.VK_DOWN) {
                planeY += 7;
            }
            if (keycode == KeyEvent.VK_UP) {
                planeY -= 7;
            }
            if (keycode == KeyEvent.VK_LEFT) {
                planeX -= 7;
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                planeX += 7;
            }
            if (planeY > 750) {
                planeY = 750;
            }
            if (planeX > 382) {
                planeX = 380;
            }
            if (planeX < 0) {
                planeX = 10;
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
