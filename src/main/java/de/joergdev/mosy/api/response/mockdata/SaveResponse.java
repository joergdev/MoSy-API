package de.joergdev.mosy.api.response.mockdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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