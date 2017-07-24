package com.lunch.things;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ThingResults {

    private List<Thing> things;

}
