//Óscar García Sahuquillo
package PagG12;

public class Hub {
    private Contenedor[][] m;
    int p=0;
    public Hub(){

        this.m = new Contenedor[10][12];

    }

    public Contenedor[][] getC(){

        return this.m;

    }

    public void setC(Contenedor[][] m){

        if(m != null){

            this.m=m;
        }

    }

// ToString

    public String toString(){

        String s = new String();


        for(int i=0 ; i<m.length ; i++){ //FILAS

            for(int j=0 ; j<m[i].length ; j++){ //COLUMNAS de la fila i

                if(m[i][j] == null) s += "[N]";
                else s += "[" + m[i][j].getId() +"-"+ m[i][j].getPeso() +"]";



            }

            s += "\n";
        }


        return s;



    }

    public Contenedor desapilar(int col){

        if (col<0 || col>=m[0].length) return null; //m[0].length nos vale porque todas las columnas tienen la misma longitud

        for(int i=0 ; i<m.length ; i++){

            if(m[i][col] != null){

                Contenedor aux = m[i][col];
                m[i][col]=null; //Lo borro

                return aux;

            }

        }

        return null;

    }

    public void apilar(Contenedor c) {
        if (c != null) {
            int p = c.getPrioridad();
            if (p == 1 || p == 2) {
                int col = p - 1;
                for (int i = m.length - 1; i >= 0; i--) {
                    if (m[i][col] == null) {
                        m[i][col] = c;
                        return;
                    }
                }
            }else if(p==3){
                for (int i = m.length - 1; i >= 0; i--) {
                    for (int j = 2; j < 12 ; j++) {
                        if(m[i][j]==null){
                            m[i][j]=c;
                            return;
                        }
                    }
                }
            }
        }
    }
    public int peso(int peso){

            p=peso+p;
        return p;
    }
}
