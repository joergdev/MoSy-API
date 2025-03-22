package de.joergdev.mosy.api.response.mockdata;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.MockData;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaveResponse", propOrder = {"stateOK", "messages", "mockData"})
public class SaveResponse extends AbstractResponse
{
  @XmlElement(name = "mockData")
  private MockData mockData;

  public MockData getMockData()
  {
    return mockData;
  }

  public void setMockData(MockData mockData)
  {
    this.mockData = mockData;
  }
}