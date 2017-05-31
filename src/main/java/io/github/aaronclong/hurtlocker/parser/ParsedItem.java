package io.github.aaronclong.hurtlocker.parser;

import java.util.Map;

/**
 * Created by aaronlong on 5/31/17.
 */
public interface ParsedItem {

  String getOriginal();

  Map<String, String> getParsed() throws ParserException;

}
