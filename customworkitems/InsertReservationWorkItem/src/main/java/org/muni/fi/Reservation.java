package org.muni.fi;

/**
 * Created by Michal on 15-Apr-17.
 */
public class Reservation implements java.io.Serializable
{

    static final long serialVersionUID = 1L;

    private java.lang.Integer id;
    private java.util.Date start;
    private java.util.Date end;
    private java.lang.Integer people;

    private java.lang.String email;

    public Reservation()
    {
    }

    public java.lang.Integer getId()
    {
        return this.id;
    }

    public void setId(java.lang.Integer id)
    {
        this.id = id;
    }

    public java.util.Date getStart()
    {
        return this.start;
    }

    public void setStart(java.util.Date start)
    {
        this.start = start;
    }

    public java.util.Date getEnd()
    {
        return this.end;
    }

    public void setEnd(java.util.Date end)
    {
        this.end = end;
    }

    public java.lang.Integer getPeople()
    {
        return this.people;
    }

    public void setPeople(java.lang.Integer people)
    {
        this.people = people;
    }

    public java.lang.String getEmail()
    {
        return this.email;
    }

    public void setEmail(java.lang.String email)
    {
        this.email = email;
    }

    public Reservation(java.lang.Integer id, java.util.Date start,
                       java.util.Date end, java.lang.Integer people, java.lang.String email)
    {
        this.id = id;
        this.start = start;
        this.end = end;
        this.people = people;
        this.email = email;
    }

}