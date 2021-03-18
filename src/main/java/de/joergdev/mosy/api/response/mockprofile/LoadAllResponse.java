package de.joergdev.mosy.api.response.mockprofile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.MockProfile;
import de.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadAllResponse", propOrder = {"stateOK", "messages", "mockProfiles"})
public class LoadAllResponse extends AbstractResponse
{
  @XmlElement(name = "mockProfiles")
  private final List<MockProfile> mockProfiles = new ArrayList<>();

  public List<MockProfile> getMockProfiles()
  {
    return mockProfiles;
  }
}