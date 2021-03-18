package de.joergdev.mosy.api.response.record;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveResponse", propOrder = {"stateOK", "messages", "recordID"})
public class SaveResponse extends AbstractResponse
{
  @XmlElement(name = "recordID")
  private Integer recordID;

  public Integer getRecordID()
  {
    return recordID;
  }

  public void setRecordID(Integer recordID)
  {
    this.recordID = recordID;
  }
}