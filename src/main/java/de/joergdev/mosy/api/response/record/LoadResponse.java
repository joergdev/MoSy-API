package de.joergdev.mosy.api.response.record;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
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