package net.tcsm.pokemonbreeders.util;

import net.tcsm.pokemonbreeders.dto.EggGroupNode;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BreedingPathSearcher {

    private final Long startGroupID;
    private final Long resultGroupID;
    private final List<EggGroupNode> allNodes;
    private List<List<Long>> resultPaths = new ArrayList<>();
    private Integer leastSteps = Integer.MAX_VALUE;


    public BreedingPathSearcher(Long startGroupID, Long resultGroupID, List<EggGroupNode> nodes) {
        this.startGroupID = startGroupID;
        this.resultGroupID = resultGroupID;
        this.allNodes = nodes;
    }

    public List<List<Long>> searchFastestPath(){
        EggGroupNode starterNode = getNode(startGroupID);
        List<Long> visitedNodes = new ArrayList<>();
        visitedNodes.add(startGroupID);

        if(starterNode.getConnectedGroups().contains(resultGroupID)){
            visitedNodes.add(resultGroupID);
            resultPaths.add(visitedNodes);
            return resultPaths;
        }

        lookUp(visitedNodes, starterNode);
        return resultPaths;
    }

    public void lookUp(List<Long> visitedNodes, EggGroupNode inspectedNode){
        for(Long neighborID : inspectedNode.getConnectedGroups()){
            List<Long> loopVisitedNodes = new ArrayList<>(visitedNodes);
            EggGroupNode neighborNode = getNode(neighborID);
            if(!loopVisitedNodes.contains(neighborID)){
                loopVisitedNodes.add(neighborID);
                if(neighborNode.getConnectedGroups().contains(resultGroupID)){
                    loopVisitedNodes.add(resultGroupID);
                    if(loopVisitedNodes.size() == leastSteps) {
                        resultPaths.add(loopVisitedNodes);
                    } else if(loopVisitedNodes.size() < leastSteps){
                        leastSteps = loopVisitedNodes.size();
                        resultPaths = new ArrayList<>();
                        resultPaths.add(loopVisitedNodes);
                    }
                } else {
                    lookUp(loopVisitedNodes, inspectedNode);
                }
            }
        }
    }

    public EggGroupNode getNode(Long groupID){
        return allNodes.stream()
                .filter(n -> n.getGroupID()
                .equals(groupID))
                .collect(toList()).get(0);
    }


}
