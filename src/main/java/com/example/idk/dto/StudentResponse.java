package com.example.idk.dto;

import com.example.idk.Models.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class StudentResponse implements Response{
    public List<Student> content;
    public int pageNum;
    public int pageSize;
    public long totalEntries;
    public int totalPages;
}
