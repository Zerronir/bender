import java.util.*;

class Bender{

    String[][] mapa;
    Robot p;
    int[] posSalida;
    String resultat = "";
    LinkedList<Integer[]> teleport = new LinkedList<>();
    LinkedList<Integer[]> inverter = new LinkedList<>();

    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        System.out.println(mapa);

        //Treïem el número de columnes que té el mapa
        String[] columns = mapa.split("\n");

        this.mapa = new String[columns.length][];
        for (int i = 0; i < columns.length; i++) {
            this.mapa[i] = columns[i].split("");
        }

        //assert false;
        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[0].length; j++) {
                if(this.mapa[i][j].equals("X")){
                    this.p = new Robot(new int[]{i, j});
                }

                if(this.mapa[i][j].equals("$")){
                    this.posSalida = new int[]{i,j};
                    System.out.println("You have arrived to your destination: " + i + " " + j);
                }

                if(this.mapa[i][j].equals("T")){
                    teleport.add(new Integer[]{i,j});
                    System.out.println("I found a teleport point at: " + i + " " + j);
                }

                if(this.mapa[i][j].equals("I")){
                    inverter.add(new Integer[]{i,j});
                    System.out.println("I found an inverter at: " + i + " " + j);
                }

            }
        }

    }

    // Navegar fins a l'objectiu («$»).
    // El valor retornat pel mètode consisteix en una cadena de // caràcters on cada lletra pot tenir
    // els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.
    public String run() {

        // Feim un StringBuilder on emmagatzemar els caracters
        // de cada passa que realitza el robot
        StringBuilder st = new StringBuilder();

        // Emmagatzemam el resultat
        String resultat = "";

        while(p.priority == p.priorityDir1){

            while(p.toSouth(this.mapa) != null){
                moveRobot();
                st.append('S');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida)){
                    return resultat;
                }
            }

            //Trencam si la prioritat no es la incial
            if (p.priority != p.priorityDir1)break;

            while(p.toEast(this.mapa) != null){
                moveRobot();
                st.append('E');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida)){
                    return resultat;
                }

            }
            if(p.priority != p.priorityDir1)break;

            if(p.toSouth(this.mapa) != null){
                moveRobot();
                st.append('S');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida)){
                    return resultat;
                }
                continue;

            }

            if(p.priority != p.priorityDir1)break;

            while(p.toNorth(this.mapa) != null){
                moveRobot();
                st.append('N');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida)){
                    return resultat;
                }

            }

            if(p.priority != p.priorityDir1)break;

            if(p.toEast(this.mapa) != null){
                moveRobot();
                st.append('E');
                resultat = st.toString();

                if (Arrays.equals(p.posicio, posSalida)){
                    return resultat;
                }
                continue;
            }

            if(p.priority != p.priorityDir1)break;

            if(p.toSouth(this.mapa) != null){
                moveRobot();
                st.append('S');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida)){
                    return resultat;
                }
                continue;
            }

            if(p.priority != p.priorityDir1)break;

            if(p.toEast(this.mapa) != null){
                moveRobot();
                st.append('E');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida)){
                    return resultat;
                }

                continue;
            }

            if(p.priority != p.priorityDir1)break;

            while(p.toWest(this.mapa) != null){
                moveRobot();
                st.append('W');
                resultat = st.toString();

                //Quan la array es igual a la posició actual y a la de sortida retornam el resultat
                if(Arrays.equals(p.posicio,posSalida)){
                    return resultat;
                }
            }

            if(p.priority != p.priorityDir1)break;
        }

        while(p.priority == p.priorityDir2){

            while(p.toNorth(this.mapa) != null){
                moveRobot();
                st.append('N');
                resultat = st.toString();
                if(Arrays.equals(p.posicio, posSalida)){
                    return resultat;
                }
            }

            if(p.priority != p.priorityDir2)break;

            while(p.toWest(this.mapa) != null){
                moveRobot();
                st.append('W');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida))return resultat;
            }

            if(p.priority != p.priorityDir2)break;

            if(p.toNorth(this.mapa) != null){
                moveRobot();
                st.append('N');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida))return resultat;
                continue;
            }

            if(p.priority != p.priorityDir2)break;

            while (p.toSouth(this.mapa) != null){
                moveRobot();
                st.append('S');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida))return resultat;

            }

            if(p.priority != p.priorityDir2)break;

            if(p.toNorth(this.mapa) != null){
                moveRobot();
                st.append('N');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida))return resultat;
                continue;
            }

            if(p.priority != p.priorityDir2)break;

            if(p.toWest(this.mapa) != null){
                moveRobot();
                st.append('W');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida))return resultat;
                continue;
            }

            if(p.priority != p.priorityDir2)break;

            if(p.toSouth(this.mapa) != null){
                moveRobot();
                st.append('S');
                resultat = st.toString();
                if(Arrays.equals(p.posicio, posSalida))return resultat;
                continue;
            }

            if(p.priority != p.priorityDir2)break;

            if(p.toNorth(this.mapa) != null){
                moveRobot();
                st.append('N');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida))return resultat;
                continue;
            }

            while(p.toEast(this.mapa) != null){
                moveRobot();
                st.append('E');
                resultat = st.toString();

                if(Arrays.equals(p.posicio, posSalida))return resultat;
            }

            if(p.priority != p.priorityDir2)break;

        }

        // Retornam el resultat
        return resultat;
    }

    // Movem el robot cap al destí
    void moveRobot(){
        this.resultat += p.lastMovement;
        printMove(this.mapa);

        // Transportam si trobam un teleportador
        if(aTeleport(p.posicio))this.mapa = transportRobot(this.mapa);

        // Invertim si trobam un inversor
        if(aInverter(p.posicio))p.priorityChange();



    }

    //Pintam el mapa
    void printMove(String[][] mapa){
        System.out.println("------------------ END OF MOVEMENT -------------------");
    }

    //Teletransportam al robot
    String[][] transportRobot (String[][] mapa){

        System.out.println("You're being transported to the next teleport point");
        for (int i = 0; i < teleport.size(); i++) {
            System.out.println(teleport.get(i)[0] + " - " + teleport.get(i)[1]);
        }

        //Donam una dimensió a l'array de teleportadors
        int[] tp = new int[2];

        if(teleport.size() == 2){
            for (int i = 0; i < teleport.size(); i++) {
                int[] tp2 = new int[]{teleport.get(i)[0], teleport.get(i)[1]};
                if(!Arrays.equals(tp2, p.posicio))tp = tp2;
            }

            p.posicio = tp;
        }

        return mapa;
    }

    //Definim si troban un inversor
    boolean aInverter(int[] coorXY){
        System.out.println("I found an inverter at: " + Arrays.toString(coorXY));
        if(inverter.size() == 0)return false;

        for (int i = 0; i < inverter.size(); i++) {
            int coorX = inverter.get(i)[0];
            int coorY = inverter.get(i)[1];

            int[] inver = new int[]{coorX, coorY};

            if(Arrays.equals(inver, coorXY))return true;

        }

        return false;
    }

    //Definim si es un teleportador
    boolean aTeleport(int[] coor) {
        System.out.println("I found a teleport point at: " + Arrays.toString(coor));
        if(teleport.size() == 0)return false;

        for (int i = 0; i < teleport.size(); i++) {
            int coorX = teleport.get(i)[0];
            int coorY = teleport.get(i)[1];

            int[] teleporter = new int[]{coorX,coorY};

            if(Arrays.equals(teleporter, coor))return true;

        }

        return false;
    }

    public int bestRun() {
        // Cream el mateix patró de moviment per al best run.
        // El que hem de conseguir es arribar al destí amb el menor número
        // de moviments possible
        int moves = 0;

        while(p.priority == p.priorityDir1){
            while(p.toSouth(this.mapa) != null){
                moveRobot();

                moves++;
            }
            if(p.priority != p.priorityDir1)break;
        }

        // Retornam el resultat dels moviments
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

    public Robot(int[] posicio) {
        this.posicio = posicio;
        System.out.println("Robot's position: " + posicio[0] + " " + posicio[1]);
    }

    //Moure cap al sud
    String[][] toSouth(String[][] mapa) {
        System.out.println("Moving southwards");

        if (mapa[posicio[0] + 1][posicio[1]].equals("#")) {
            return null;
        } else {
            mapa[posicio[0]][posicio[1]] = " ";
            mapa[posicio[0] + 1][posicio[1]] = "X";
            posicio[0] = posicio[0] + 1;
            lastMovement = 'S';
            movements++;
        }

        return mapa;
    }

    //Funció per moure el Robot cap a l'est
    String[][] toEast(String[][] mapa) {
        System.out.println("Moving east");
        if (mapa[posicio[0]][posicio[1] + 1].equals("#")) {
            return null;
        } else {
            mapa[posicio[0]][posicio[1]] = " ";
            mapa[posicio[0]][posicio[1] + 1] = "X";
            posicio[1] = posicio[1] + 1;
            lastMovement = 'E';
            movements++;
        }

        return mapa;
    }

    //Funció per a moure el robot cap al nord
    String[][] toNorth(String[][] mapa) {
        System.out.println("Moving north");

        if (mapa[posicio[0] - 1][posicio[1]].equals("#")) {
            return null;
        } else {
            mapa[posicio[0]][posicio[1]] = " ";
            mapa[posicio[0] - 1][posicio[1]] = "X";
            posicio[0] = posicio[0] - 1;
            lastMovement = 'N';
            movements++;
        }

        return mapa;
    }

    //Funcio per a moure el robot cap a l'oest
    String[][] toWest(String[][] mapa) {
        System.out.println("Moving west");

        if (mapa[posicio[0]][posicio[1] - 1].equals("#")) {
            return null;
        } else {
            mapa[posicio[0]][posicio[1]] = " ";
            mapa[posicio[0]][posicio[1] - 1] = "X";
            posicio[1] = posicio[1] - 1;
            lastMovement = 'W';
            movements++;
        }
        return mapa;
    }

    //Camviem les prioritats
    public void priorityChange() {
        if (priority == priorityDir1) {
            priority = priorityDir2;
        } else {
            priority = priorityDir1;
        }
    }
}
