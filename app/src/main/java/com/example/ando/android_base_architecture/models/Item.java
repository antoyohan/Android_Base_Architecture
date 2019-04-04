package com.example.ando.android_base_architecture.models;

public class Item {
    private Owner owner;

    private String score;

    private String is_accepted;

    private String last_activity_date;

    private String creation_date;

    private String answer_id;

    private String question_id;

    public Owner getOwner ()
    {
        return owner;
    }

    public void setOwner (Owner owner)
    {
        this.owner = owner;
    }

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    public String getIs_accepted ()
    {
        return is_accepted;
    }

    public void setIs_accepted (String is_accepted)
    {
        this.is_accepted = is_accepted;
    }

    public String getLast_activity_date ()
    {
        return last_activity_date;
    }

    public void setLast_activity_date (String last_activity_date)
    {
        this.last_activity_date = last_activity_date;
    }

    public String getCreation_date ()
    {
        return creation_date;
    }

    public void setCreation_date (String creation_date)
    {
        this.creation_date = creation_date;
    }

    public String getAnswer_id ()
    {
        return answer_id;
    }

    public void setAnswer_id (String answer_id)
    {
        this.answer_id = answer_id;
    }

    public String getQuestion_id ()
    {
        return question_id;
    }

    public void setQuestion_id (String question_id)
    {
        this.question_id = question_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [owner = "+owner+", score = "+score+", is_accepted = "+is_accepted+", last_activity_date = "+last_activity_date+", creation_date = "+creation_date+", answer_id = "+answer_id+", question_id = "+question_id+"]";
    }
}
