/**
 * Copyright Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.firebase.codelab.friendlychat;

import java.util.HashMap;

public class FriendlyMessage {

    private String chatRoomID;
    private String originalLanguage;
    private String name;
    private String photoUrl;
    private HashMap<String, String> message;

    public FriendlyMessage() {
    }

    public FriendlyMessage(String chatRoomID, String text, String name, String photoUrl, String originalLanguage) {
        this.chatRoomID = chatRoomID;
        this.name = name;
        this.photoUrl = photoUrl;
        this.originalLanguage = originalLanguage;
        this.message = new HashMap<String, String>();
        message.put(originalLanguage, text);
    }

    public String getChatRoomID() { return chatRoomID; }
    public void setChatRoomID(String chatRoomID) { this.chatRoomID = chatRoomID; }

    public String getOriginalLanguage() { return originalLanguage; }
    public void setOriginalLanguage(String originalLanguage) { this.originalLanguage = originalLanguage; }

    public HashMap<String, String> getMessage() { return message; }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
}
