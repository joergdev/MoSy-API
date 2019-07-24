package com.github.joergdev.mosy.api.response.system;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.model.BaseData;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadBaseDataResponse", propOrder = {"stateOK", "messages", "baseData"})
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