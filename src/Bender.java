import java.util.*;

class Bender{
    String[][] mapa;
    Player p;
    int[] posSalida;
    String resultado = "";
    LinkedList<Integer[]> teleport = new LinkedList<>();
    LinkedList<Integer[]> iterator = new LinkedList<>();
    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        System.out.println(mapa);

        String [] rows = mapa.split("\n");
        String[] columns = new String[0];

        for (int i = 0; i < rows.length; i++) {
            columns = columns.toCharArray();
        }

        this.mapa = new String[columns.length][];
        for (int i = 0; i < columns.length; i++) {
            this.mapa[i] = columns[i].split("");
        }

        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[0].length; j++) {
                if (this.mapa[i][j].equals("X")) {
                    this.p = new Player(new int[]{i, j});
                }
                if (this.mapa[i][j].equals("$")) {
                    this.posSalida = new int[]{i, j};
                }
                if (this.mapa[i][j].equals("T")) {
                    teleport.add(new Integer[]{i, j});
                    System.out.println("There's a teleport ! " + i + " " + j);
                }
                if (this.mapa[i][j].equals("I")) {
                    iterator.add(new Integer[]{i, j});
                    System.out.println("There's a iterator!! " + i + " " + j);
                }
            }
        }


    }

    // Navegar fins a l'objectiu («$»).
    // El valor retornat pel mètode consisteix en una cadena de // caràcters on cada lletra pot tenir
    // els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.
    public String run() {

        //Emmagatzemam el resultat
        String resultat = "";
        boolean llistat = true;




        return "";
    }

    public int bestRun() {
        return 0;
    }

}