package de.joergdev.mosy.api.response.recordconfig;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.RecordConfig;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadResponse", propOrder = {"stateOK", "messages", "recordConfig"})
public class LoadResponse extends AbstractResponse
{
  @XmlElement(name = "recordConfig")
  private RecordConfig recordConfig;

  public RecordConfig getRecordConfig()
  {
    return recordConfig;
  }

  public void setRecordConfig(RecordConfig recordConfig)
  {
    this.recordConfig = recordConfig;
  }
}