function addTag(tag, value){
    const newTag = document.createElement(tag);
    const textNode = document.createTextNode(value);
    newTag.appendChild(textNode);
    return newTag;
}
