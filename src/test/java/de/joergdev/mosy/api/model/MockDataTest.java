package de.joergdev.mosy.api.model;

import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;

public class MockDataTest
{
  @Test
  public void test_setRequestResponseByFileContent()
    throws Exception
  {
    String content = new String(Files.readAllBytes(Paths.get(MockDataTest.class.getResource("/sample_mockdata_rest.txt").toURI())));

    MockData mockData = new MockData();
    mockData.setRequestResponseByFileContent(content);

    assertEquals(Integer.valueOf(200), mockData.getHttpReturnCode());

    assertEquals(1, mockData.getPathParams().size());
    assertEquals("id", mockData.getPathParams().get(0).getKey());
    assertEquals("0a00143c-9102-107e-8191-037ff27600eb", mockData.getPathParams().get(0).getValue());

    assertTrue(mockData.getRequest().isEmpty());

    StringBuilder buiResponse = new StringBuilder();
    buiResponse.append("{");
    buiResponse.append("\"creationDate\" : \"2024-07-30T13:56:42.512157\",");
    buiResponse.append("\"description\" : \"HelloWorld123\"");
    buiResponse.append("}");
    assertEquals(buiResponse.toString().replace(" ", "").trim(), //
        mockData.getResponse().replace("\r", "").replace("\n", "").replace(" ", "").trim());
  }
}
