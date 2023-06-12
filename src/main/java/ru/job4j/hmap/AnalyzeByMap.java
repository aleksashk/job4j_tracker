package ru.job4j.hmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0D;
        List<Label> labels = averageScoreByPupil(pupils);
        for (Label label : labels) {
            score += label.score();
        }
        return score / pupils.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil p : pupils) {
            int score = 0;
            int counter = 0;
            for (Subject s : p.subjects()) {
                score += s.score();
                counter++;
            }
            labels.add(new Label(p.name(), score / (double) counter));
        }

        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subj : subjects) {
                map.merge(subj.name(), subj.score(), (oldValue, newValue) -> oldValue + subj.score());
            }
        }

        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labels.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        int score = 0;
        for (Pupil p : pupils) {
            for (Subject subj : p.subjects()) {
                score += subj.score();
            }
            list.add(new Label(p.name(), score));
            score = 0;
            list.sort(Comparator.naturalOrder());
        }
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subj : subjects) {
                map.merge(subj.name(), subj.score(), (oldValue, newValue) -> oldValue + subj.score());
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue()));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
