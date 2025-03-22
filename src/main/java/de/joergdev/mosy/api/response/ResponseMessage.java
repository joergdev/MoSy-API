package de.joergdev.mosy.api.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseMessage", propOrder = {"responseCode", "additionalInfos"})
public class ResponseMessage
{
  public ResponseMessage()
  {

  }

  public ResponseMessage(ResponseCode responseCode)
  {
    this.responseCode = responseCode;
  }

  @XmlElement(name = "responseCode")
  private ResponseCode responseCode;

  @XmlElement(name = "additionalInfos")
  private List<String> additionalInfos = new ArrayList<>();

  public List<String> getAdditionalInfos()
  {
    return additionalInfos;
  }

  public void setAdditionalInfos(List<String> additionalInfos)
  {
    this.additionalInfos = additionalInfos;
  }

  public ResponseMessage withAddtitionalInfo(String additionalInfo)
  {
    ResponseMessage cln = clone();

    if (additionalInfo != null)
    {
      cln.additionalInfos.add(additionalInfo);
    }

    return cln;
  }

  public ResponseCode getResponseCode()
  {
    return responseCode;
  }

  public void setResponseCode(ResponseCode responseCode)
  {
    this.responseCode = responseCode;
  }

  public ResponseMessage clone()
  {
    ResponseMessage cln = new ResponseMessage(responseCode);
    cln.additionalInfos.addAll(additionalInfos);

    return cln;
  }

  public String getFullMessage()
  {
    StringBuilder bui = new StringBuilder();

    if (responseCode != null)
    {
      bui.append(responseCode.message);
    }

    if (!additionalInfos.isEmpty())
    {
      bui.append(" [");

      Iterator<String> it = additionalInfos.iterator();
      while (it.hasNext())
      {
        bui.append(it.next());

        if (it.hasNext())
        {
          bui.append(", ");
        }
      }

      bui.append("]");
    }

    return bui.toString();
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(additionalInfos, responseCode);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }

    if (obj instanceof ResponseMessage == false)
    {
      return false;
    }

    ResponseMessage other = (ResponseMessage) obj;

    return Objects.equals(additionalInfos, other.additionalInfos) //
           && responseCode == other.responseCode;
  }

  @Override
  public String toString()
  {
    StringBuilder bui = new StringBuilder();

    if (responseCode != null)
    {
      bui.append("[").append(responseCode.level).append("] - ").append(responseCode.code);
    }

    String fullMsg = getFullMessage();
    if (fullMsg != null && !fullMsg.trim().isEmpty())
    {
      if (bui.length() > 0)
      {
        bui.append(" - ");
      }

      bui.append(fullMsg);
    }

    return bui.toString();
  }
}