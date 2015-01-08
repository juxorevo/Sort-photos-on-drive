package juxo.apiCalendar.definitionClasse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultReminders", namespace = "http://search.yahoo.com/mrss/", propOrder = {
    "method",
    "minutes"
    
})

public class DefaultReminders {
@XmlElement
protected String method;
@XmlElement
protected String minutes;


public String getMinutes() {
	return minutes;
}

public void setMinutes(String minutes) {
	this.minutes = minutes;
}

public String getMethod() {
	return method;
}

public void setMethod(String method) {
	this.method = method;
}
}
