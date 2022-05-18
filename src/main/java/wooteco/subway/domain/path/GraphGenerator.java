package wooteco.subway.domain.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wooteco.subway.domain.section.Section;
import wooteco.subway.domain.station.Station;

public class GraphGenerator {

    public static Map<Station, List<PathElement>> toAdjacentPath(List<Section> sections) {
        Map<Station, List<PathElement>> adjacentPaths = new HashMap<>();
        for (Section section : sections) {
            adjacentPaths.put(section.getUpStation(), new ArrayList<>());
            adjacentPaths.put(section.getDownStation(), new ArrayList<>());
        }
        for (Section section : sections) {
            Station upStation = section.getUpStation();
            Station downStation = section.getDownStation();
            int distance = section.getDistance();
            adjacentPaths.get(upStation).add(new PathElement(downStation, distance));
            adjacentPaths.get(downStation).add(new PathElement(upStation, distance));
        }
        return adjacentPaths;
    }
}