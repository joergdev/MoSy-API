package de.joergdev.mosy.api.response._interface.method;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.RecordConfig;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadRecordConfigsResponse", propOrder = {"stateOK", "messages", "recordConfigs"})
public class LoadRecordConfigsResponse extends AbstractResponse
{
  @XmlElement(name = "recordConfigs")
  private final List<RecordConfig> recordConfigs = new ArrayList<>();

  public List<RecordConfig> getRecordConfigs()
  {
    return recordConfigs;
  }
}