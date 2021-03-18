package de.joergdev.mosy.api.response._interface.method;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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