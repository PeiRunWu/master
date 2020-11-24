public class DemoMain {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("艾希");
        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("pa~pa~pa");
            }
        });
        hero.attack();
        Skill skill =new SkillImpl();
        System.out.println(skill.num);
    }
}
