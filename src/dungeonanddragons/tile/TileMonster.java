package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.hero.Hero;
import dungeonanddragons.monster.Monster;

/**
 * Représente une tuile contenant un monstre dans le jeu Donjon et Dragons.
 * Lorsque le héros arrive sur cette tuile, un combat se déclenche.
 * @author Anne-Laure PLANO
 */
public class TileMonster extends Tile {

    /** Le monstre contenu dans la tuile */
    private Monster content = null;

    /**
     * Constructeur de la tuile monstre.
     * @param content le monstre contenu dans la tuile
     */
    public TileMonster(Monster content){
        super("monster");
        this.content = content;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void interact(Menu menu, Hero player){

    }

    /**
     * Exécute un round de combat entre le héros et le monstre.
     * Le héros attaque en premier, puis le monstre contre-attaque s'il est encore en vie.
     * @param heros le héros qui combat
     * @param menu le menu du jeu
     */
    public void executeCombatRound(Hero heros, Menu menu) {

            // le héros attaque :
            heros.displayAttack();
            this.getContent().decreasePV(heros.getAtkTotal());
            menu.displayMonsterPV(getContent().getColor(), getContent().getType(), heros.getAtkTotal(), getContent().getPv(), getContent().getMaxPV());

            if (this.isMonsterAlive()) {
                //le monstre contre-attaque
                this.getContent().displayDefense();
                heros.decreasePV(this.getContent().getAtk());
                menu.displayHeroPV(heros.getPv(), heros.getMaxPV());

            } else {
                this.getContent().displayIsKilled();
                heros.displayVictoryCombat();
            }
    }

    /**
     * Gère le déroulement complet du combat jusqu'à sa résolution.
     * Le combat se termine quand le monstre est vaincu, le héros fuit ou le héros est mort.
     * @param menu le menu du jeu
     * @param player le héros qui combat
     * @return true si le héros a fui, false sinon
     */
    public boolean executeCombat(Menu menu,Hero player){
        boolean heroIsEscaped = false;
        boolean heroIsAlive = true;
        while (isMonsterAlive() && !heroIsEscaped &&  heroIsAlive) {
            int userChoice = menu.displayIsWantToBattle();
            switch (userChoice) {
                case 1:  //attaque le monstre
                    executeCombatRound(player, menu);
                    break;
                case 2:  //fuite du héros
                    heroIsEscaped = player.canHeroEscape();
                    if (!heroIsEscaped) {
                        monsterAttack(player, menu);
                    }
                    break;
                case 3: // use potion
                    if (player.getBag().getSlots()!=null){
                        player.getBag().selectItem(menu, player);
                        monsterAttack(player, menu);
                    } else {
                        menu.bagEmpty();
                        heroIsEscaped = executeCombat(menu, player);
                    }
                    break;
            }
            heroIsAlive = player.isAlive();

        }
        return heroIsEscaped;
    }

    /**
     * Déclenche l'attaque du monstre sur le héros.
     * @param heros le héros qui subit l'attaque
     * @param menu le menu du jeu
     */
    public void monsterAttack(Hero heros,  Menu menu) {
        this.getContent().displayAttack();
        heros.decreasePV(this.getContent().getAtk());
        menu.displayHeroPV(heros.getPv(), heros.getMaxPV());

    }

    /**
     * Vérifie si le monstre est encore en vie.
     * @return true si les points de vie du monstre sont supérieurs à 0, false sinon
     */
    public boolean isMonsterAlive(){
        if (this.getContent().getPv()>0){
            return true;
        } return false;
    }

    /**
     * Retourne le monstre contenu dans la tuile.
     * @return le monstre de la tuile
     */
    public Monster getContent(){
        return this.content;
    }

    /**
     * Modifie le monstre contenu dans la tuile.
     * @param content le nouveau monstre
     */
    public void setContent(Monster content) {
        this.content = content;
    }

    /**
     * Supprime le monstre de la tuile.
     */
    public void deleteContent(){
        this.content = null;
    }


}
