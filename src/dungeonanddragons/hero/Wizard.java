package dungeonanddragons.hero;


public class Wizard extends Hero {
    private String pseudo;

    public Wizard(String pseudo ){
        super( pseudo, "Wizard",  6,  8,  null, 0);
    }

    @Override
    public void displayAttack() {
        System.out.println("""
                Vous attaquez :
                Vos doigts tracent des signes anciens, une lueur violette pulse entre vos paumes.
                L'obscurité obéit.
                """);
    }

    public String displayHero() {
        return """
                        ____\s
                      .'* *.'
                   __/_*_*(_
                  / _______ \\
                 _\\_)/___\\(_/_\s
                / _((\\- -/))_ \\
                \\ \\())(-)(()/ /
                 ' \\(((()))/ '
                / ' \\)).))/ ' \\
               / _ \\ - | - /_  \\
              (   ( .;''';. .'  )
              _\\"__ /    )\\ __"/_
                \\/  \\   ' /  \\/
                 .'  '...' ' )
                  / /  |  \\ \\
                 / .   .   . \\
                /   .     .   \\
               /   /   |   \\   \\
             .'   /    b    '.  '.
         _.-'    /     Bb     '-. '-._\s
     _.-'       |      BBb       '-.  '-.\s
    (___________\\____.dBBBb.________)____)
    
    
    """ +super.toString();
    }
}
