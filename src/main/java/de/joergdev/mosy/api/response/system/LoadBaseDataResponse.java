package de.joergdev.mosy.api.response.system;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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