function removeTag(tag){
    while(tag.firstChild){
        tag.removeChild(tag.firstChild);
    }
}
