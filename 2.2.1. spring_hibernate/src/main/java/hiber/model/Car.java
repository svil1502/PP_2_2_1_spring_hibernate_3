package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Car")
public class Car implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "carId")
    private User user;

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        user.setCar(this);
        this.user = user;
    }


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Column(name = "model")
    String model;

    public Car() {
    }


    @Column(name = "series")
    int series;


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }


}
