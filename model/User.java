package model;

import java.util.List;

public class User{
    private int id;
    private List<UserClassJogador> jogadoresClassificados;


    public User(int id, List<UserClassJogador> jogadoresClassificados) {
        this.id = id;
        this.jogadoresClassificados = jogadoresClassificados;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UserClassJogador> getJogadoresClassificados() {
        return this.jogadoresClassificados;
    }

    public void setJogadoresClassificados(List<UserClassJogador> jogadoresClassificados) {
        this.jogadoresClassificados = jogadoresClassificados;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", jogadoresClassificados='" + getJogadoresClassificados().toString() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getId() == user.getId();
    }
}