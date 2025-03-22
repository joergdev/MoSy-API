package de.joergdev.mosy.api.response.system;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.BaseData;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadBaseDataResponse", propOrder = {"baseData"})
public class LoadBaseDataResponse extends AbstractResponse
{
  @XmlElement(name = "baseData")
  private BaseData baseData;

  public BaseData getBaseData()
  {
    return baseData;
  }

  public void setBaseData(BaseData baseData)
  {
    this.baseData = baseData;
  }
}