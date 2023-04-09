package PagG12;
public class Puerto {
    private Hub hubNorte;
    private Hub hubEste;
    private Hub hubSur;

    public Puerto() {
        this.hubNorte = new Hub();
        this.hubEste = new Hub();
        this.hubSur = new Hub();
    }
    public Hub getHubNorte() {
        return this.hubNorte;
    }
    public void setHubNorte(Hub hubNorte) {
        if (hubNorte != null) {
            this.hubNorte = hubNorte;
        }
    }
    public Hub getHubEste() {
        return this.hubEste;
    }
    public void setHubEste(Hub hubEste) {
        if (hubEste != null) {
            this.hubEste = hubEste;
        }
    }
    public Hub getHubSur() {
        return this.hubSur;
    }
    public void setHubSur(Hub hubSur) {
        if (hubSur != null) {
            this.hubSur = hubSur;
        }
    }
    public void apilarEnHubNorte(Contenedor c) {
        this.hubNorte.apilar(c);
    }
    public void apilarEnHubEste(Contenedor c) {
        this.hubEste.apilar(c);
    }
    public void apilarEnHubSur(Contenedor c) {
        this.hubSur.apilar(c);
    }
    public Contenedor desapilarDelHubNorte(int col) {
        return this.hubNorte.desapilar(col);
    }
    public Contenedor desapilarDelHubEste(int col) {
        return this.hubEste.desapilar(col);
    }
    public Contenedor desapilarDelHubSur(int col) {
        return this.hubSur.desapilar(col);
    }
}
