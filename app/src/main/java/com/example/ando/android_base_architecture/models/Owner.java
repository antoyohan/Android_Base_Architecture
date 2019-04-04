package com.example.ando.android_base_architecture.models;

public class Owner {
    private String profile_image;

    private String user_type;

    private String user_id;

    private String link;

    private String reputation;

    private String display_name;

    public String getProfile_image ()
    {
        return profile_image;
    }

    public void setProfile_image (String profile_image)
    {
        this.profile_image = profile_image;
    }

    public String getUser_type ()
    {
        return user_type;
    }

    public void setUser_type (String user_type)
    {
        this.user_type = user_type;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getReputation ()
    {
        return reputation;
    }

    public void setReputation (String reputation)
    {
        this.reputation = reputation;
    }

    public String getDisplay_name ()
    {
        return display_name;
    }

    public void setDisplay_name (String display_name)
    {
        this.display_name = display_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [profile_image = "+profile_image+", user_type = "+user_type+", user_id = "+user_id+", link = "+link+", reputation = "+reputation+", display_name = "+display_name+"]";
    }
}
