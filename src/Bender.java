import java.util.*;

class Bender{
    String[][] mapa;
    Robot p;
    int[] posSalida;
    String resultado = "";
    LinkedList<Integer[]> teleport = new LinkedList<>();
    LinkedList<Integer[]> iterator = new LinkedList<>();

    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        System.out.println(mapa);
        String[][] mape = this.mapa;

        //Treïem el número de files que té el mapa
        String[] rows = mapa.split("\n");
        char[] columns = new char[0];

        for (int i = 0; i < rows.length; i++) {
            columns = Arrays.toString(rows).toCharArray();
        }

        char[][] map = new char[rows.length][columns.length];
        int k = 0;

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                if(this.mapa[i][j].equals("X")){
                    System.out.println("robot a: " + i + " " + j);
                    this.p = new Robot(new int[]{i, j});
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

        while(p.priority == p.priorityDir1){
            p.toSouth(mapa);

            return Arrays.deepToString(p.toSouth(mapa));
        }

        return "";
    }

    public int bestRun() {
        return 0;
    }

}

class Robot {
    int movements = 0;
    char lastMovement = '0';
    int[] posicio;
    //Declaram les prioritats de les direccions
    char[] priorityDir1 = new char[]{'S', 'E', 'N', 'W'};
    char[] priorityDir2 = new char[]{'N', 'W', 'S', 'E'};
    char[] priority = priorityDir1;

    public Robot(int[] posicio){
        this.posicio = posicio;
        System.out.println("La posició del robot es: " + posicio[0] + " " + posicio[1]);
    }

    //Moure cap al sud
    String[][] toSouth(String[][] mapa){
        System.out.println("Moving southwards");

        if(mapa[posicio[0] +1 ][posicio[1]].equals("#")){
            return null;
        }else{
            mapa[posicio[0]][posicio[1]] = " ";
            mapa[posicio[0]+1][posicio[1]] = "X";
            posicio[0] = posicio[0] + 1;
            lastMovement = 'S';
            movements++;
        }

        return mapa;
    }

    public void priority() {
    }
}