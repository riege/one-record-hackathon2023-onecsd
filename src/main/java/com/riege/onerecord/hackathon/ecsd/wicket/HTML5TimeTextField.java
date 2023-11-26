package com.riege.onerecord.hackathon.ecsd.wicket;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

public class HTML5TimeTextField extends TextField<String>
{
    public HTML5TimeTextField(final String id, final IModel<String> model)
    {
        super(id, model);
    }

    protected String[] getInputTypes()
    {
        return new String[] {"time"} ;
    }
}
