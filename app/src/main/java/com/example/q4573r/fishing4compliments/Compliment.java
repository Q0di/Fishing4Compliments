package com.example.q4573r.fishing4compliments;

/**
 * Created by Q0di on 3/13/2016.
 */
public class Compliment {
    //DB fields
    private int _id;
    private String _compliment;

    //empty constructor
    public Compliment() {
    }

    public Compliment(String compliment) {
       this._compliment = compliment;

    }
    //getters and setters
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_compliment() {
        return _compliment;
    }

    public void set_compliment(String _compliment) {
        this._compliment = _compliment;
    }

    //to string method
    @Override
    public String toString() {
        return "Compliment{" +
                "_id=" + _id +
                ", _compliment='" + _compliment + '\'' +
                '}';
    }
}
