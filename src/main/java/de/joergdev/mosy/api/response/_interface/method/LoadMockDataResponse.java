package de.joergdev.mosy.api.response._interface.method;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.MockData;
import de.joergdev.mosy.api.response.AbstractResponse;

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