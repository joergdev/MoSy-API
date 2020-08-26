package com.github.joergdev.mosy.api.response._interface.method;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.model.MockData;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadMockDataResponse", propOrder = {"stateOK", "messages", "mockData"})
public class LoadMockDataResponse extends AbstractResponse
{
  @XmlElement(name = "mockData")
  private final List<MockData> mockData = new ArrayList<>();

  public List<MockData> getMockData()
  {
    return mockData;
  }
}