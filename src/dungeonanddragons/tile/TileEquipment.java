package dungeonanddragons.tile;

import dungeonanddragons.Menu;
import dungeonanddragons.equipment.Equipment;
import dungeonanddragons.equipment.consumable.Consumable;
import dungeonanddragons.hero.Hero;

/**
 * Représente une tuile contenant un équipement dans le jeu Donjon et Dragons.
 * Lorsque le héros arrive sur cette tuile, il peut interagir avec l'équipement.
 * @author Anne-Laure PLANO
 */
public class TileEquipment extends Tile {

    /** L'équipement contenu dans la tuile */
    private Equipment content = null;

    /**
     * Constructeur de la tuile équipement.
     * @param content l'équipement contenu dans la tuile
     */
    public TileEquipment(Equipment content){
        super("equipment");
        this.content = content;
    }

    /**
     * {@inheritDoc}
     * Si le contenu est un consommable, propose au héros de l'utiliser,
     * de le mettre dans son sac ou de le laisser.
     * Sinon, déclenche directement l'interaction avec l'équipement.
     */
    @Override
    public void interact( Menu menu, Hero heros) {

        menu.displayTileEquipment(this.content.toString());

        if (this.getContent() instanceof Consumable) {
            int answer = menu.askLootAction();
            switch (answer) {
                case 1: //use
                    this.content.interact(heros, menu);
                    break;
                case 2: //put on the bag
                    heros.getBag().addItem(this.content);
                    break;
                default: // let in place
                    menu.youLetTheObject();
                    break;
            }
        } else{
            getContent().interact(heros, menu);
        }
    }

    /**
     * Retourne l'équipement contenu dans la tuile.
     * @return l'équipement de la tuile
     */
    public Equipment getContent(){
            return this.content;
        }

    /**
     * Modifie l'équipement contenu dans la tuile.
     * @param content le nouvel équipement
     */
    public void setContent(Equipment content) {
            this.content = content;
        }



    }
