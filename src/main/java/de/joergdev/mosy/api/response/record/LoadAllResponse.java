package de.joergdev.mosy.api.response.record;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.Record;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadAllResponse", propOrder = {"stateOK", "messages", "records"})
public class LoadAllResponse extends AbstractResponse
{
  @XmlElement(name = "records")
  private final List<Record> records = new ArrayList<>();

  public List<Record> getRecords()
  {
    return records;
  }
}