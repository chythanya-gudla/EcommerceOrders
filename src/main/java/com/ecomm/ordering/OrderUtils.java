package com.ecomm.ordering;

import static java.util.Map.entry;

import java.util.Map;

public class OrderUtils {

  public static Map<String, Double> taxMap = Map.ofEntries(
          entry("02038", 10.0),
          entry("02039", 20.0)
  );

  public static Map<String, Double> shippingChargeMap = Map.ofEntries(
          entry("02038", 10.0),
          entry("02039", 20.0)
  );
}
