/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.errorprone.bugpatterns.testdata;

/** @author yulissa@google.com (Yulissa Arroyo-Paredes) */
public class ArgumentParameterSwapNegativeCases {
  public String doSomething(String[] keepPath, String[] dropPath) {
    return "wrong";
  }

  //names are identical
  public void doSomethingElse() {
    String[] keepPath = {"one", "two", "three"};
    String[] dropPath = {"one"};
    doSomething(keepPath, dropPath);
  }

  public void doNothing() {
    doSomething(null, new String[0]);
  }

  // there is a swap here but because the args is less than 4 characters long then we ignore
  public String sendSomething(String from, String to, boolean video) {
    return "wrong but ignore";
  }

  public void sendReversed() {
    String from = "from";
    String to = "to";
    boolean video = false;
    sendSomething(to, from, video);
  }
}
