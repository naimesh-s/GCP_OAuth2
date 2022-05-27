package com.externalModeller.gcp.GCPWebApp;

//[START automl_get_model_beta]
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.Model;
import com.google.cloud.automl.v1beta1.ModelName;
import io.grpc.StatusRuntimeException;
import java.io.IOException;

public class GetModel {
	
	static void getModel() throws IOException, StatusRuntimeException {
	    // TODO(developer): Replace these variables before running the sample.
	    String projectId = "YOUR_PROJECT_ID";
	    String modelId = "YOUR_MODEL_ID";
	    getModel(projectId, modelId);
	  }

	  // Get a model
	  static void getModel(String projectId, String modelId)
	      throws IOException, StatusRuntimeException {
	    // Initialize client that will be used to send requests. This client only needs to be created
	    // once, and can be reused for multiple requests. After completing all of your requests, call
	    // the "close" method on the client to safely clean up any remaining background resources.
	    try (AutoMlClient client = AutoMlClient.create()) {
	      // Get the full path of the model.
	      ModelName modelFullId = ModelName.of(projectId, "us-central1", modelId);
	      Model model = client.getModel(modelFullId);

	      // Display the model information.
	      System.out.format("Model name: %s%n", model.getName());
	      // To get the model id, you have to parse it out of the `name` field. As models Ids are
	      // required for other methods.
	      // Name Format: `projects/{project_id}/locations/{location_id}/models/{model_id}`
	      String[] names = model.getName().split("/");
	      String retrievedModelId = names[names.length - 1];
	      System.out.format("Model id: %s%n", retrievedModelId);
	      System.out.format("Model display name: %s%n", model.getDisplayName());
	      System.out.println("Model create time:");
	      System.out.format("\tseconds: %s%n", model.getCreateTime().getSeconds());
	      System.out.format("\tnanos: %s%n", model.getCreateTime().getNanos());
	      System.out.format("Model deployment state: %s%n", model.getDeploymentState());
	    }
	  }
}
