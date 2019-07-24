package com.github.joergdev.mosy.api.response.mockdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveResponse", propOrder = {"stateOK", "messages", "mockDataID"})
public class SaveResponse extends AbstractResponse
{
  @XmlElement(name = "mockDataID")
  private Integer mockDataID;

  public Integer getMockDataID()
  {
    return mockDataID;
  }

  public void setMockDataID(Integer mockDataID)
  {
    this.mockDataID = mockDataID;
  }
}