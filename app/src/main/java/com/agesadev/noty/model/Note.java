package com.agesadev.noty.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int node_id;

    @ColumnInfo(name = "note_content")
    private String content;

    private String title;

    public Note(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public Note(int node_id, String content, String title) {
        this.node_id = node_id;
        this.content = content;
        this.title = title;
    }

    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return node_id == note.node_id && Objects.equals(content, note.content) && Objects.equals(title, note.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node_id, content, title);
    }

    @Override
    public String toString() {
        return "Note{" +
                "node_id=" + node_id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
