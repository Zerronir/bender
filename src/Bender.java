import java.util.*;

class Bender{
    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        System.out.println(mapa);

        String [] rows = mapa.split("\\r?\\n");
        char[] columns = new char[0];

        for (int i = 0; i < rows.length; i++) {
            columns = Arrays.toString(rows).toCharArray();
        }

        char[][] map = new char[rows.length][columns.length];

        int pos = 0;
        int posRobot = 0;


        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                char c = mapa.charAt(j);

                if(c == 'X'){
                    map[i][j] = c;
                    posRobot = j;
                    System.out.println(posRobot);
                }

                map[i][j] = c;
                System.out.println(c);
            }
        }

        System.out.println(Arrays.toString(rows) + " " + Arrays.toString(columns));


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