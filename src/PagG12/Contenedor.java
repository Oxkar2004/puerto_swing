//Óscar García Sahuquillo
package PagG12;
public class Contenedor {
    private final int id;
    private int peso,prioridad;
    private String pais,contenido,emisor,receptor;
    private boolean inspeccionado;


    // CONTRUCTORES

    public Contenedor(int id){

        if(id<0) id=-id;
        this.id=id;
        prioridad=3;
    }

    public Contenedor(int id,int peso,int prioridad,String pais,String contenido,String emisor,String receptor,boolean inspeccionado){

        this(id);
        this.peso=peso;
        this.prioridad=prioridad;
        this.pais=pais;
        this.contenido=contenido;
        this.emisor=emisor;
        this.receptor=receptor;
        this.inspeccionado=inspeccionado;
    }

    // GETTERS Y SETTERS

    public int getId(){
        return this.id;
    }

    public int getPeso(){

        return this.peso;
    }

    public int getPrioridad(){

        return this.prioridad;
    }

    public String getPais(){

        return this.pais;
    }

    public String getContenido(){

        return this.contenido;
    }

    public String getEmisor(){

        return this.emisor;
    }

    public String getReceptor(){

        return this.receptor;
    }

    public void setPeso(int peso){

        if(peso>0)  this.peso=peso;
    }

    public void setPrioridad(int prioridad){

        if(prioridad >=1 && prioridad <=3) this.prioridad=prioridad;

    }

    public void setPais(String pais){

        this.pais=pais;
    }

    public void setContenido(String contenido){

        this.contenido=contenido;
    }

    public void setEmisor(String emisor){

        this.emisor=emisor;
    }

    public void setReceptor(String receptor){

        this.receptor=receptor;
    }

    public boolean isInspeccionado(){

        return this.inspeccionado;
    }

    // ToString

    public String toString(){

        String s= new String();

        s += "ID: " + id + "\n";
        s += "PESO: " + peso + "\n";
        s += "PRIORIDAD: " + prioridad + "\n";
        s += "PAIS: " + pais + "\n";
        s += "CONTENIDO: " + contenido + "\n";
        s += "EMISOR: " + emisor + "\n";
        s += "RECEPTOR: " + receptor + "\n";


        if(inspeccionado) s += "Inspeccionado\n";
        else s += "No inspeccionado\n";

        return s;
    }

}
