package model;

public class RankingEnvios {
    private String nameCity;
    private int envios;

    public RankingEnvios() {
    }
    
    
    public RankingEnvios(String nameCity, int envios) {
        this.nameCity = nameCity;
        this.envios = envios;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getEnvios() {
        return envios;
    }

    public void setEnvios(int envios) {
        this.envios = envios;
    }

    @Override
    public String toString() {
        return nameCity + " - " + envios;
    }
    
    
}
