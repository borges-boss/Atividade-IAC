package iac.atividade;

/**
 *
 * @author borge
 */
public class Ficha {

    private double altura;
    private short sexo;

    public Ficha(double altura, short sexo) {
        this.altura = altura;
        this.sexo = sexo;
    }

    public void setAltura(short altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setSexo(short sexo) {
        this.sexo = sexo;
    }

    public short getSexo() {
        return this.sexo;
    }

}
