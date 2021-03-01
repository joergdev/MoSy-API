package de.joergdev.mosy.api.response.record;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.Record;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadResponse", propOrder = {"stateOK", "messages", "record"})
public class LoadResponse extends AbstractResponse
{
  @XmlElement(name = "record")
  private Record record;

  public Record getRecord()
  {
    return record;
  }

  public void setRecord(Record record)
  {
    this.record = record;
  }
}